import React, { useState, useEffect } from 'react';
import axios from 'axios';
import EmployeeList from './components/EmployeeList';
import './App.css';

const App = () => {
  const [employees, setEmployees] = useState([]);
  const [empid, setEmpid] = useState('');
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');

  useEffect(() => {
    axios.get('http://localhost:8080/employees')
      .then(response => {
        console.log(response.data); // Log the API response
        setEmployees(response.data);
      })
      .catch(error => console.error('Error fetching employees:', error));
  }, []);

  // Handle search by employee ID
  const handleSearchById = () => {
    axios.get(`http://localhost:8080/employees/${empid}`)
      .then(response => {
        setEmployees([response.data]); // Update state with the employee found by ID
      })
      .catch(error => console.error('Error searching employee by ID:', error));
  };

  // Handle search by date range
  const handleSearchByDateRange = () => {
    axios.get(`http://localhost:8080/employees/search-by-date`, {
      params: {
        startDate: startDate,
        endDate: endDate
      }
    })
      .then(response => {
        setEmployees(response.data); // Update state with employees in date range
      })
      .catch(error => console.error('Error searching employees by date range:', error));
  };

  return (
    <div className="container">
      <h1>Employee Management</h1>
      <div className="search-container">
        <div className="search-by-id">
          <input
            type="text"
            placeholder="Enter Employee ID"
            value={empid}
            onChange={(e) => setEmpid(e.target.value)}
          />
          <button onClick={handleSearchById}>Search</button>
        </div>
        <div className="search-by-date">
          <input
            type="date"
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
          <input
            type="date"
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
          <button onClick={handleSearchByDateRange}>Search</button>
        </div>
      </div>
      <EmployeeList employees={employees} />
    </div>
  );
};

export default App;
