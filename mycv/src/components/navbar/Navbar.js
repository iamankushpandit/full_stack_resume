import React, { Component } from 'react';
//import 'materialize-css/dist/css/materialize.min.css';
import { HashLink as Link } from 'react-router-hash-link';

export default class Navbar extends Component {
	render() {
		return (
			<>
				<nav className='indigo darken-4'>
					<div className='container'>
						<div className='nav-wrapper'>
							<Link to='/' className='brand-logo'>
								
							</Link>
							<Link to='/' data-target='side-nav' className='sidenav-trigger'>
								<i className='material-icons'>menu</i>
							</Link>
							<ul className='right hide-on-med-and-down'>
								<li>
									<Link to='/'>
										<i class='fas fa-home'></i> Home
									</Link>
								</li>
								<li>
									<Link to='/responsibilities'>
									<i class="fas fa-dumbbell"></i> Responsibilities
									</Link>
								</li>
								<li>
									<Link to='/skills'>
									<i class="fas fa-drafting-compass"></i> Skills
									</Link>
								</li>
								<li>
									<Link to='/experiences'>
										<i class='fas fa-id-badge'></i> Experiences
									</Link>
								</li>
								<li>
									<Link to='/education'>
										<i class='fas fa-graduation-cap'></i> Education
									</Link>
								</li>
								<li>
									<Link to='/certifications'>
										<i class='fas fa-certificate'></i> Certifications
									</Link>
								</li>
								<li>
									<Link to='/open_source_contributions'>
									<i class="fab fa-osi"></i> OSS
									</Link>
								</li>
								<li>
									<Link to='/conferences'>
									<i class="far fa-comments"></i> Conferences
									</Link>
								</li>
								<li>
									<Link to='/awards'>
									<i class="fas fa-trophy"></i> Awards
									</Link>
								</li>
							</ul>
						</div>
					</div>
				</nav>
				<ul className='sidenav' id='side-nav'>
					<li>
						<Link to='/'>
							<i class='fas fa-home'></i> Home
						</Link>
					</li>
					<li>
						<Link to='/responsibilities'>
						<i class="fas fa-dumbbell"></i> Responsibilities
						</Link>
					</li>
					<li>
						<Link to='/skills'>
						<i class="fas fa-drafting-compass"></i> Skills
						</Link>
					</li>
					<li>
						<Link to='/experiences'>
							<i class='fas fa-id-badge'></i> Experiences
						</Link>
					</li>
					<li>
						<Link to='/education'>
							<i class='fas fa-graduation-cap'></i> Education
						</Link>
					</li>
					<li>
						<Link to='/certifications'>
							<i class='fas fa-certificate'></i> Certifications
						</Link>
					</li>
					<li>
						<Link to='/open_source_contributions'>
						<i class="fab fa-osi"></i> OSS
						</Link>
					</li>
					<li>
						<Link to='/conferences'>
						<i class="far fa-comments"></i> Conferences
						</Link>
					</li>
					<li>
						<Link to='/awards'>
							<i class="fas fa-trophy"></i> Awards
						</Link>
					</li>
				</ul>
			</>
		);
	}
}
