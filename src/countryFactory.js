//Add imports here
import React, {Components} from 'react';



class CountryFactory {

  constructor() { 
    
  }

  getLabels() {
    return fetch("http://localhost:3333/labels").then(Response => Response.json());
  }

 getCountries() {
    return  fetch("http://localhost:3333/countries").then(Response => Response.json());
  }

}

export default new CountryFactory();