import React from 'react';
import 'materialize-css/dist/css/materialize.min.css';
import 'materialize-css/dist/js/materialize.min.js';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Home from './components/pages/Home';
import Skills from './components/pages/skills/Skills';
import Experiences from './components/pages/experiences/Experiences';
import Certifications from './components/pages/certifications/Certifications';
import Education from './components/pages/education/Education';
import Responsibilities from './components/pages/responsibilities/Responsibilities';
import Awards from './components/pages/awards/Awards';
import Conferences from './components/pages/conferences/Conferences';
import OSS from './components/pages/OSS/OSS';
import './App.css';
function App() {

  return (
    <Router>
      <>
        <Route exact path="/" component={Home} />
        <Switch>
          <Route path="/responsibilities" component={Responsibilities}/>
          <Route path="/skills" component={Skills}/>
          <Route path="/experiences" component={Experiences} />
          <Route path="/education" component={Education} />
          <Route path="/certifications" component={Certifications} />
          <Route path="/awards" component={Awards} />
          <Route path="/conferences" component={Conferences} />
          <Route path="/open_source_contributions" component={OSS} />
        </Switch>
      </>
    </Router>
  );
}

export default App;
