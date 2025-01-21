import React from 'react';

const EmployeeList = ({ employees }) => {
  return (
    <div className="employee-list">
      <h2>Employee List</h2>
      {employees.length === 0 ? (
        <p>No employees found.</p>
      ) : (
        <ul>
          {employees.map(employee => (
            <li key={employee.empid}>
              {employee.empFname} {employee.empLname} (Joined: {new Date(employee.empJoinDate).toLocaleDateString()})
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default EmployeeList;
