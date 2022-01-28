import React from 'react';
import ImgProfile from '../../../images/loading.gif';


class About extends React.Component {
  constructor() {
    super();
    this.state = {
      headline: ["Holder for About me. If you are seeing this please check headline service."],
      personal_info: ["Holder for Personal Information. If you are seeing this please check demographic service."],
      loading: true
    };
  }

  componentDidMount() {
    fetch("http://localhost:18084/api/v1/headline/candidate_id/1")
      .then(res => res.json())
      .then(data => this.setState({ headline: data[0].headline }));

    fetch("http://localhost:18081/api/v1/demographic/")
      .then(res => res.json())
      .then(data => this.setState({ personal_info: data[0] }))
      .then(() => this.setState({ loading: false}));
  }
  render() {
    const { loading } = this.state;
    if (loading) {
      return (<div>
        <div className="card">
          <div className="card-content">
            <p>
              <b>{this.state.headline}</b>
            </p>
          </div>
          <div className="card-action">
            <h6>
              <strong>PERSONAL INFO</strong>
            </h6>
            <img src={ImgProfile} alt='Loading' />
          </div>
        </div>
      </div>);
    }
    return (
      <div>
        <div className="card">
          <div className="card-content">
            <p>
              <b>{this.state.headline}</b>
            </p>
          </div>
          <div className="card-action">
            <h6>
              <strong>PERSONAL INFO</strong>
            </h6>
            <div className="row mt">
              <div className="col xl6 l6 m6 s12">
                <p>
                  <strong>Address:</strong> {this.state.personal_info.candidate_first_address},{this.state.personal_info.candidate_city}, {this.state.personal_info.candidate_state},{this.state.personal_info.candidate_contry} {this.state.personal_info.candidate_zip}
                </p>
                <p>
                  <strong>Email:</strong> {this.state.personal_info.candidate_email}
                </p>
                <p>
                  <strong>Phone:</strong> {this.state.personal_info.candidate_phone_number}
                </p>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default About;