import React from 'react';
import ImgProfile from '../../../images/loading.gif';


class Skills extends React.Component {
  constructor() {
    super();
    this.state = {
      tools: ["Holder for the Tools information. If you are seeing this please check the tools service."],
      loading: true
    };
  }

  componentDidMount() {
    fetch("http://ec2-34-214-97-188.us-west-2.compute.amazonaws.com:18086/api/v1/tools/candidate_id/1")
      .then(res => res.json())
      .then(data => this.setState({ tools: data }))
      .then(() => this.setState({loading:false}));
  }
  render() {
    const { loading } = this.state;
    if (loading) {
      return (<div>
        <div className="card">
          <div className="card-content">
            <h6>
              <i class="fas fa-drafting-compass"></i><strong>  PROFESSIONAL SKILLS</strong>
            </h6>
            <img src={ImgProfile} alt='Loading' />
          </div>
        </div>
      </div>);
    } return (
      <div>
        <div className="card">
          <div className="card-content">
            <h6>
              <i class="fas fa-drafting-compass"></i><strong>  PROFESSIONAL SKILLS</strong>
            </h6>
            <blockquote className="no-pad">
              {
                this.state.tools.map
                  (tool =>
                    <>
                      <p><b>{tool.tool_type}</b> : {tool.tools}</p>
                    </>
                  )
              }
            </blockquote>
          </div>
        </div>
      </div>
    );
  }
}
export default Skills;