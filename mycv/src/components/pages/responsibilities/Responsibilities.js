import React from 'react';
import ImgProfile from '../../../images/loading.gif';

class Responsibilities extends React.Component {

	constructor() {
		super();
		this.state = {
			responsibilities: ["Holder for Responsibilities information. If you are seeing this please check the responsibilities service."],
			loading: true
		};
	}
	componentDidMount() {
		fetch("http://ec2-54-245-38-45.us-west-2.compute.amazonaws.com:18085/api/v1/responsibilities/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ responsibilities: data[0].responsibilities }))
			.then(() => this.setState({loading:false}));
	}

	render() {

	const { loading } = this.state;
		if (loading) {
			return (<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class="fas fa-dumbbell"></i><strong>  RESPONSIBILITIES</strong>
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
							<i class="fas fa-dumbbell"></i><strong>  RESPONSIBILITIES</strong>
						</h6>
						<blockquote className="no-pad">
							{String(this.state.responsibilities).replaceAll(',', '').split(".").map(responsibility => responsibility && responsibility !== ' ' ? <ul><i class="fas fa-arrow-circle-right"></i> {responsibility}.</ul> : '')}
						</blockquote>
					</div>
				</div>
			</div>
		);
	}

}
export default Responsibilities;