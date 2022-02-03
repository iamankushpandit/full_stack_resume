import React, { Component } from 'react';
import ImgProfile from '../../../images/loading.gif';


class OSS extends Component {

	constructor() {
		super();
		this.state = {
			oss: ["Holder for the Open Source Contributions information. If you are seeing this please check the experience service."],
			loading: true
		};
	}

	componentDidMount() {
		fetch("http://ec2-34-221-200-239.us-west-2.compute.amazonaws.com:18083/api/v1/open_source_contribution/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ oss: data }))
			.then(() => this.setState({loading:false}));
	}

	render() {
		const { loading } = this.state;
		if (loading) {
			return (<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class="fab fa-osi"></i> <strong>  OPEN SOURCE CONTRIBUTIONS</strong>
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
							<i class="fab fa-osi"></i> <strong>  OPEN SOURCE CONTRIBUTIONS</strong>
						</h6>
						<table class='striped'>
							<thead>
								<tr>
									<th>Issue</th>
									<th>Product</th>
								</tr>
							</thead>
							<tbody>
								{this.state.oss.map(ossc =>
									<tr>
										<td><a href={ossc.evidence_url}>{ossc.issue}</a></td>
										<td>{ossc.product}</td>
									</tr>)}
							</tbody>
						</table>
					</div>
				</div>
			</div>
		);
	}
}

export default OSS;