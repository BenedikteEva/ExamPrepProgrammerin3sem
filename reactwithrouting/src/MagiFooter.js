import React from 'react';
import './MagicHeader.css';




function Name(props) {
  return <a> {props.name}</a>;
}


function MagiFooter() {
  return (<div className="MagiFooter">
    <footer className="App-footer">
    <Name name=" © BenedikteEva 2018" />
      <img src={"https://lh3.googleusercontent.com/-5g1S5EKLMw4/WnIVGZmltLI/AAAAAAAAMTY/PPZSzee81Ek8WRRl7vX3C6Hg9Kj6v8pHwCEwYBhgL/w140-h139-p/logo7g.png"} className="App-miniLogo" alt="logo" />
    </footer>

  </div>);
}




export default MagiFooter;
