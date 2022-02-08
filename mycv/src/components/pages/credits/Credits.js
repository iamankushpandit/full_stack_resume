import React, { Component } from 'react';

class Credits extends Component {
	constructor() {
		super();
	}

	render() {
		return (
			<div>
				<div class='card'>
					<div class='card-content'>
						<h6>
                            <i class="fa-solid fa-hat-wizard"></i> <strong>  Credits</strong>
						</h6>
						This webpage is developed and maintained by Ankush Pandit and source can be found at <a href="https://github.com/iamankushpandit/full_stack_resume">https://github.com/iamankushpandit/full_stack_resume</a>.
					</div>
				</div>
			</div>
		);
	}
}

export default Credits;