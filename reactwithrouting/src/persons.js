import React from 'react';

const URL = "http://localhost:3456/api";

//Simple way to handle HTTP-errors which otherwise does not throw an exception with the fetch-API
function handleHttpErrors(res) {
  if (!res.ok) {
    throw Error(res.statusText);
  }
  return res.json();
}


class Persons extends React.Component {

  constructor() {
    super();
    this.state= {persons: []}
  }

  async componentDidMount() {
    //This would be the perfect place to fetch persons from the API
    return await fetch(URL).then(Response =>  Response.json());
    this.setState({
      persons: data
    })
  }
/* 
  updatePerson = async (person) => {
    await this.props.facade.updatePerson(person);
    let data = await this.props.facade.getPersons();
    this.setState({
      persons: data
    })
  }

  postPerson = async (person) => {
    await this.props.facade.addPerson(person);
    let data = await this.props.facade.getPersons();
    this.setState({
      persons: data
    })
  }

  deletePerson = async (id) => {
    await this.props.facade.deletePerson(id);
    let data = await this.props.facade.getPersons();
    this.setState({
      persons: data
    })
  }
 */
  render() {
    return (
      <div style={{ margin: 20, width: "70%" }}>
        <h3>CRUD Demo </h3>
        <div className="row">
          <div className="col-md-6">
            <h3>All Persons</h3>
            <AllPersons persons={this.state.persons} />
          </div>
      {/*     <div className="col-md-6" >
            <h3 style={{textAlign:"center"}}>Add Persons</h3>
            <AddEditPerson postPerson={this.postPerson} />
          </div> */}
        </div>

      </div>
    );
  }
}





 

  async addPerson (person){
     await fetch(URL, makeOptions("POST", person));
  }
  async updatePerson (id,person){
    await fetch(URL + "/" + id, makeOptions("PUT", person));
 }



  async deletePerson(id){
    await fetch(URL + "/" + id, makeOptions("DELETE"));
  }


  

 }

export default Persons;