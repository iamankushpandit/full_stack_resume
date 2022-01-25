import React from 'react';

class Certifications extends React.Component
{
	constructor()
	{
		super();
		this.state = {
			certifications: ["Holder for the Certification information. If you are seeing this please check the education service."]
		};
	}

	componentDidMount()
	{
		fetch("http://localhost:18082/api/v1/certification/candidate_id/1")
		.then(res => res.json())
		.then(data => this.setState({certifications:data}));
	}

	render()
	{
		return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
						<i class='fas fa-certificate'></i><strong>  CERTIFICATIONS</strong>
						</h6>
						<table class='striped'>
							<thead>
								<tr>
									<th>Certificate</th>
									<th>Completion Date</th>
									<th>Institution</th>
								</tr>
							</thead>
							<tbody>
							{this.state.certifications.map(cert => 
									<tr>
										<td>{cert.certification_name}</td>
										<td>{cert.certification_complete_date}</td>
										<td>{cert.certification_institution_name}</td>
									</tr>)}
							</tbody>
						</table>
					</div>
				</div>
			</div>
		);
	}
}
export default Certifications;
