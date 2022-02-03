import React from 'react';
import Moment from 'moment';
import ImgProfile from '../../../images/loading.gif';


class Experiences extends React.Component {
  constructor() {
    super();
    this.state = {
      experience: ["Holder for the Experience information. If you are seeing this please check the experience service."],
      loading: true
    };
  }

  componentDidMount() {
    fetch("http://ec2-34-221-200-239.us-west-2.compute.amazonaws.com:18083/api/v1/job_profile/candidate_id_comp/1")
      .then(res => res.json())
      .then(data => this.setState({ experience: data }))
      .then(() => this.setState({loading:false}));
  }
  render() {
    const { loading } = this.state;
    if (loading) {
      return (<div>
        <div className="card">
          <div className="card-content">
            <h6>
              <i class='fas fa-id-badge'></i><strong>  EXPERIENCE</strong>
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
              <i class='fas fa-id-badge'></i><strong>  EXPERIENCE</strong>
            </h6>
            {
              this.state.experience.map(xp =>
                <div className="row mt-top">
                  <div className="col xl4 l4 m6 s12">
                    <p className="black company white-text">
                      {xp.company_name}
                    </p>
                    <p className="teal year_exp white-text">
                      <strong>{Moment(xp.job_start_date).format('MMM YYYY')} - {xp.job_end_date == null ? "Present" : Moment(xp.job_end_date).format('MMM YYYY')}</strong>
                    </p>
                  </div>
                  <div className="col xl8 l8 m6 s12">
                    <blockquote className="no-pad">
                      <h6 className="no-pad mt-bottom">
                        <strong>{xp.job_title}</strong>
                      </h6>
                      <h6 className="no-pad mt-bottom">
                        <strong>Duties:</strong>
                      </h6>

                      {String(xp.job_duties).replaceAll(',', '').split(".").map(duty => duty && duty !== ' ' ? <ul><b>-</b> {duty}.</ul> : '')}

                      {
                        xp.job_highlights && xp.job_highlights.length === 0 ?
                          <><h6 className="no-pad mt-bottom"><strong>Highlights:</strong></h6><p><ul>{String(xp.job_highlights).replaceAll(',', '').split(".").map(highlight => highlight && highlight !== ' ' ? <li> {highlight}.</li> : '')}</ul></p></>
                          : <p></p>
                      }
                    </blockquote>
                  </div>
                </div>
              )
            }
          </div>
        </div>
      </div>
    );
  }
}
export default Experiences;