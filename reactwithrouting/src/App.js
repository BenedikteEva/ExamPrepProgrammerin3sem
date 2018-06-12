import React, { Component } from 'react';
import './App.css';
import MagiHeader from './MagiHeader';
import MagiFooter from './MagiFooter';
import {
  HashRouter as Router,
  Route,  
  Link, NavLink, Switch
} from 'react-router-dom'
import AllUsers from './AllUsers';




const Welcome = () => (
  <div>
    <h2> Welcome to our friends site</h2>
    <img src="https://scontent-arn2-1.xx.fbcdn.net/v/t1.0-9/1376495_651583471526593_874558031_n.jpg?_nc_cat=0&oh=e79a9f994f407d006eeee4b9c5d8d40b&oe=5B726BB3" alt="myPic" height="100"></img>
  </div>
)


const App = () => (
  <div>
    <main>

      <MagiHeader> </MagiHeader>


      <Router>
        <div >

            <ul className="header">

              <li ><Link to="/" className="activeV2">Welcome</Link></li>
              <li><Link to="/all">See All Users</Link></li>
         
  
            </ul>
    

          <hr />
          <Switch>

            <Route exact path="/" component={Welcome} />
            <Route  path="/all" component={AllUsers} />
           
       
         {/* <Route path="/:id" render={() => (<p> Nothing to show yet</p>)} />  */}
          </Switch>
        </div>
      </Router>

      <MagiFooter></MagiFooter>


    </main>


  </div>
)
export default App


//surge --project ./build --domain benedikterouterex2.surge.sh
