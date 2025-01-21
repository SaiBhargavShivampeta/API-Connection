import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import './index.css';

const root = document.getElementById('root');
if (root) {
    ReactDOM.createRoot(root).render(<App />);
} else {
    console.error('Root container not found!');
}
