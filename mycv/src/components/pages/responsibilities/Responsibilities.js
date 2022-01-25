import React from 'react';



class Responsibilities extends React.Component {

	constructor() {
		super();
		this.state = {
			responsibilities: ["Holder for Responsibilities information. If you are seeing this please check the responsibilities service."]
		};
	}
	componentDidMount() {
		fetch("http://localhost:18085/api/v1/responsibilities/candidate_id/1")
			.then(res => res.json())
			.then(data => this.setState({ responsibilities: data[0].responsibilities }));
	}

	render() {
		return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
							<i class="fas fa-dumbbell"></i><strong>  RESPONSIBILITIES</strong>
						</h6>
						<blockquote className="no-pad">
							{String(this.state.responsibilities).replaceAll(',', '').split(".").map(responsibility => responsibility && responsibility !== ' ' ? <ul><b>&gt;</b> {responsibility}.</ul> : '')}
						</blockquote>
					</div>
				</div>
			</div>
		);
	}

}
export default Responsibilities;