import React, { Component } from 'react';
import Navbar from '../../components/navbar/Navbar';
import Profile from '../../components/pages/profile/Profile';
import About from '../../components/pages/about/About';
import Responsibilities from './responsibilities/Responsibilities';
import Skills from '../../components/pages/skills/Skills';
import Experiences from '../../components/pages/experiences/Experiences';
import Education from './education/Education';
import Certifications from './certifications/Certifications';
import Conferences from './conferences/Conferences';
import Awards from './awards/Awards';
import OSS from './OSS/OSS';

export default class Home extends Component {
	constructor(props)
	{
		super(props);
		this.state={
			personal_info: "Holder for Personal Information. If you are seeing this please check demographic service."
		};
	}

	componentDidMount()
	{
		fetch("http://ec2-34-219-26-110.us-west-2.compute.amazonaws.com:18081/api/v1/demographic/")
		.then(res => res.json())
		.then(data => this.setState({personal_info:data[0]}));
	}

	render() {
		return (
			<section>
				<Navbar />
				<div className='container'>
					<div className='row'>
						<div className='col s12 m3'>
							<Profile
							personal_info={this.state.personal_info}
							/>
						</div>
						<div className='col s12 m9'>
							<About/>
							<Responsibilities/>
							<Skills/>
							<Experiences/>
							<Education/>
							<Certifications/>
							<OSS/>
							<Conferences/>
							<Awards/>
						</div>
					</div>
				</div>
			</section>
		);
	}
}
