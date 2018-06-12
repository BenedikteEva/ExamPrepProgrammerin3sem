import React from 'react';
import './MagicHeader.css';




function Title(props){
  return <h2> {props.title}</h2>;
}


function MagiHeader() {
  return ( <div className="MagiHeader">
  <header className="App-header">
    <img src={"https://lh3.googleusercontent.com/-5g1S5EKLMw4/WnIVGZmltLI/AAAAAAAAMTY/PPZSzee81Ek8WRRl7vX3C6Hg9Kj6v8pHwCEwYBhgL/w140-h139-p/logo7g.png"} className="App-logo" alt="logo" />
  <Title title="React With Routing" />
  </header>
  </div>);
}




export default MagiHeader;
