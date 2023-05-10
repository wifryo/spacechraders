import './App.css';
import React, { Fragment, useEffect, useState } from 'react';
import logo from './logo.svg';

function App() {
  const [retrievedEmployees, setRetrievedEmployees] = useState([{}]);

  async function getEmployees() {
    const response = await fetch(`/employees/showAll`, {
      method: 'GET',
    });
    const employees = await response.json();
    setRetrievedEmployees(employees);
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        {retrievedEmployees.map((employee) => (
          <div>{employee.firstName}</div>
        ))}
      </header>
    </div>
  );
}

export default App;
