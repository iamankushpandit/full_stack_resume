import React, { Component } from 'react';
import ImgProfile from '../../../images/loading.gif';


class Conferences extends Component {

	constructor() {
		super();
		this.state = {
			conferences: ["Holder for the Conferences information. If you are seeing this please check the experience service."],
			loading: true
		};
	}

	componentDidMount() {
		fetch("http://ec2-34-221-98-135.us-west-2.compute.amazonaws.com:18083/api/v1/conference/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ conferences: data }))
			.then(() => this.setState({loading:false}));
	}

	render() {
		const { loading } = this.state;
		if (loading) {
			return (<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class="far fa-comments"></i> <strong>  CONFERENCE PARTICIPATION</strong>
						</h6>
						<img src={ImgProfile} alt='Loading' />
					</div>
				</div>
			</div>);
		} return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class="far fa-comments"></i> <strong>  CONFERENCE PARTICIPATION</strong>
						</h6>
						<table class='striped'>
							<thead>
								<tr>
									<th>Conference</th>
									<th>Topic</th>
									<th>Role</th>
									<th>Year</th>
								</tr>
							</thead>
							<tbody>
								{this.state.conferences.map(conf =>
									<tr>
										<td>{conf.conference_institution_name}</td>
										<td>{conf.topic}</td>
										<td>{conf.role}</td>
										<td>{conf.conference_year}</td>
									</tr>)}
							</tbody>
						</table>
					</div>
				</div>
			</div>
		);
	}
}

export default Conferences;