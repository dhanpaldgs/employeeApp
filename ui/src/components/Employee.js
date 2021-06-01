import React, { useState } from 'react';
import axios from 'axios';

const Employee = props => {


    const [name, setName] = React.useState("");
    const [empList, setEmpList] = React.useState([]);
    const [error,setError] =React.useState(null);
    
    const submitHandler = event => {
        event.preventDefault();

        const BASE_URL = "http://localhost:8888/search";


        axios.get(BASE_URL + "/" + name).then(response => {

            if(response.status == "200"){
                console.log(response.data);
                setEmpList(response.data);
            }else{
                setError(response.data);
            }
                
        })
    }

    const changeHandler = event => {
       setName(event.target.value);
       const BASE_URL = "http://localhost:8888/search";


        axios.get(BASE_URL + "/" + event.target.value).then(response => {

            if(response.status == "200"){
                console.log(response.data);
                setEmpList(response.data);
            }else{
                setError(response.data);
            }
                
        })
    }

    let list = [];
    if(empList.length > 0){
        list= empList.map((emp, index) => {
            return (
                <h4><li key={index}>
                 {emp}
                </li></h4>
            );
          });
    }else{
        list=<h4>Data not found</h4>
    }

    return <div>
        <form onSubmit={submitHandler}>
        <h1>Employee </h1>

        <label>
            Name:
        <input
                name="name"
                type="name"
                value={name}
                onChange={changeHandler}
                required />
        </label>

        <button type="click" onClick={submitHandler} onChange={submitHandler}>Search</button>
        </form>
        <div>
        {list}
        </div>

    </div>
}

export default Employee;