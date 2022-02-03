import React from 'react';
import ImgProfile from '../../../images/loading.gif';


class Certifications extends React.Component {
	constructor() {
		super();
		this.state = {
			certifications: ["Holder for the Certification information. If you are seeing this please check the education service."],
			loading: true
		};
	}

	componentDidMount() {
		fetch("http://ec2-35-87-1-56.us-west-2.compute.amazonaws.com:18082/api/v1/certification/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ certifications: data }))
			.then(() => this.setState({loading:false}));
	}

	render() {
		const { loading } = this.state;
		if (loading) {
			return (
				<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class='fas fa-certificate'></i><strong>  CERTIFICATIONS</strong>
						</h6>
						<img src={ImgProfile} alt='Loading' />
					</div>
				</div>
			</div>
			);
		} return (
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
