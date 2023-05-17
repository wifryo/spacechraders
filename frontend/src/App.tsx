import './App.css';
import React, { Fragment, useEffect, useState } from 'react';
import logo from './logo.svg';

function App() {
  const [retrievedData, setRetrievedData] = useState({
    accountId: '',
    symbol: '',
    headquarters: '',
    credits: '',
  });

  async function getData() {
    const response = await fetch(`http://localhost:8080/api/greg`, {
      method: 'GET',
    });
    const data = await response.json();
    setRetrievedData(data.data);
  }

  useEffect(() => {
    getData().catch((err) => {
      console.log(err);
    });
  }, []);

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
        <div>{retrievedData.symbol}</div>
      </header>
    </div>
  );
}

export default App;
