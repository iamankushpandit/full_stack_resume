import React from 'react';
import { HashLink as Link } from 'react-router-hash-link';
import ImgProfile from '../../../images/person1.jpg';

export default function Profile({personal_info}) {
	return (
		<div>
			<div className='card'>
				<div className='card-image'>
					<img className='activator' src={ImgProfile} alt='Ankush Pandit' />
					<Link className='btn-floating halfway-fab waves-effect waves-light red'>
						<i className='material-icons activator'>more_vert</i>
					</Link>
				</div>
				<div className='card-content'>
					<span className='card-title activator grey-text text-darken-4'>
					<p>{personal_info.candidate_first_name} {personal_info.candidate_last_name}</p>
					</span>
					<p>Full Stack Engineer</p>
					<p><a href="https://github.com/iamankushpandit/full_stack_resume">Source Code for this page
					</a></p>
				</div>
				<div className='card-reveal'>
					<span className='card-title grey-text text-darken-4'>
						Follow Me
						<i className='material-icons right'>close</i>
					</span>
					<p className='flex-container'>
						<a href={personal_info.candidate_github_url}><i className='fab fa-github grey-text text-darken-4 social_style'></i></a>
						<a href="https://www.linkedin.com/in/ankushpandit/"><i className='fab fa-linkedin grey-text text-darken-4 social_style'></i></a>
					</p>
				</div>
			</div>
		</div>
	);
}
