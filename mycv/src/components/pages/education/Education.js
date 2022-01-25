import React from 'react';

class Education extends React.Component {
	constructor() {
		super();
		this.state = {
			education: ["Holder for Education information. If you are seeing this please check the education service."]
		};
	}
	componentDidMount() {
		fetch("http://localhost:18082/api/v1/education/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ education: data }));
	}

	render() {
		return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
						<i class='fas fa-graduation-cap'></i><strong>  EDUCATION</strong>
						</h6>
						<table class='striped'>
							<thead>
								<tr>
									<th>Degree</th>
									<th>Complete Date</th>
									<th>College</th>
									<th>Degree Specialization</th>
								</tr>
							</thead>
							<tbody>
								{
									this.state.education.map(deg =>
										<tr key={deg.degree_id}>
											<td>{deg.degree_name}</td>
											<td>{deg.degree_complete_date}</td>
											<td>{deg.degree_college_name} {deg.degree_college_address}</td>
											<td>{deg.degree_specialization}</td>
										</tr>)
								}
							</tbody>
						</table>
					</div>
				</div>
			</div>
		);
	}
}
export default Education;