import React, {Component} from 'react';
import CountryTable from "./CountryTable";
import './App.css';

class App extends Component {
  
  constructor(){
    super();
    this.state = {labels: [], countries: [], timer: 0
    }
  }
  componentDidMount() {
    //This would be the perfect place to fetch persons from the API
    this.timerID = setInterval( () => this.tick(), 3000);
  }

  tick = async () => {
    let data = await this.props.factory.getLabels();
    let country = await this.props.factory.getCountries();
    let timer = this.state.timer + 1;
    this.setState({
      labels: data,
      countries: country,
      timer: timer
    })
  }

  componentDidUpdate()  {
    console.log("Update has happened!")
  }

  render() {
    return (
      <div>
        <div className="App-header">
          <h2>React, State, Fetch </h2>
        
        </div>
        <div className="App-intro">
          <p>Gui has been updated = {this.state.timer}</p>          
          <CountryTable labels={this.state.labels} countries={this.state.countries}/>
        </div>
      </div>
    );
  }
}

export default App;
