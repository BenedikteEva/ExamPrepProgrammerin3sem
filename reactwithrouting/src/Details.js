import React from 'react';







const Details = ({ match, data}) => {
  const URL = "http://localhost:3456/users";

  fetch(URL+"?first="+match.params.id)
  .then(results => {
  
    return results.json();
  }).then(datas => {
   

const uDetails = datas.map((u) => {
console.log(datas)
 return (

       <div>
   
       <h2>{u.first} {u.last}</h2>
      <p>{u.gender}</p>
      <p>{u.title}</p> 
    <p>{u.street}</p> 
      <p>{u.city}</p>
      <p>{u.state}</p>
      <p>{u.zip}</p>
      <p>{u.email}</p>
      <p>{u.dob}</p>
      <p>{u.phone}</p>
      <p>{u.cell}</p>  
 <img src={u.picture.large}alt="thumb"></img> 
</div>
)})


    return (

      <div >

            {uDetails} 
     
    </div>

) 
}
)
}
export default Details;
