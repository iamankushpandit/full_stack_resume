import React, { Component } from 'react';
import ImgProfile from '../../../images/loading.gif';


class Awards extends Component {
	constructor() {
		super();
		this.state = {
			awards: ["Holder for the Award information. If you are seeing this please check the experience service."],
			loading: true
		};
	}

	componentDidMount() {
		fetch("http://ec2-34-221-98-135.us-west-2.compute.amazonaws.com:18083/api/v1/award/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ awards: data }))
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
							<i class="fas fa-trophy"></i> <strong>  AWARDS</strong>
						</h6>
						<img src={ImgProfile} alt='Loading' />
					</div>
				</div>
			</div>
			);
		}
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