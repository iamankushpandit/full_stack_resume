import React, { Component } from 'react';

class Awards extends Component {
    constructor()
	{
		super();
		this.state = {
			awards: ["Holder for the Award information. If you are seeing this please check the experience service."]
		};
	}

	componentDidMount()
	{
		fetch("http://localhost:18083/api/v1/award/candidate_id/1")
		.then(res => res.json())
		.then(data => this.setState({awards:data}));
	}
    
    render() {
        return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
                        <i class="fas fa-trophy"></i> <strong>  AWARDS</strong>
						</h6>
						<table class='striped'>
							<thead>
								<tr>
									<th>Award Name</th>
									<th>Project</th>
                                    <th>Year</th>
									<th>Institution</th>
								</tr>
							</thead>
							<tbody>
							{this.state.awards.map(award => 
									<tr>
										<td>{award.awards_name}</td>
										<td>{award.project_name}</td>
										<td>{award.awards_year}</td>
                                        <td>{award.awards_institution_name}</td>
									</tr>)}
							</tbody>
						</table>
					</div>
				</div>
			</div>
		);
    }
}

export default Awards;