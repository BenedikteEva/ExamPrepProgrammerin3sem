import React from 'react';
import Details from './Details';
import {
  HashRouter as Router,
  Route,  
  Link, NavLink, Switch
} from 'react-router-dom'

const URL = "http://localhost:3456/users";

class AllUsers extends React.Component {

  constructor(props) {
    super(props);
    this.state = { users: this.props.users }

  }

  componentDidMount() {

    fetch(URL)
      .then(results => {
        if (!results.ok) {
          throw Error(results.statusText);
        }
        return results.json();
      }).then(data => {

        const users = data.map((user) => {
          return (
     
            <tr key={user.first}>
                <td><img src={user.picture.thumbnail}alt="thumb"></img></td>
              <td>{user.first} {user.last}</td>
              <td><Link to={`/all/${user.first}`}>Details</Link> </td>
            
             
              </tr>   
          )
        })
        this.setState({ users: users })

      })
  }
  render() {


    return (

<div>
 
   
      <table className="table">

        <thead>
          <tr>
            <th></th><th>Name</th><th>Details</th>
          </tr>
        </thead>
        <tbody>
          {this.state.users}
        
        </tbody>
      </table>
      
      <Route path={`/all/:id`}  render={(props) => <Details {...props} />}/>

</div>
 
    );
  }

}






export default AllUsers;