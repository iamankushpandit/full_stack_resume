import React from 'react';

class Skills extends React.Component
{
  constructor() {
    super();
    this.state = {tools:["Holder for the Tools information. If you are seeing this please check the tools service."]};
  }

  componentDidMount() 
  {
    fetch("http://localhost:18087/api/v1/tools/candidate_id/1")
		.then(res => res.json())
		.then(data => this.setState({tools:data}));  
  }
  render()
  {
    return(
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