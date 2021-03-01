import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import store from './store/index.js';
import './index.css';
import App from './app/App';
import reportWebVitals from './reportWebVitals';
import registerServiceWorker from './registerServiceWorker';
// Service Worker
import * as serviceWorker from "./serviceWorker";

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
//reportWebVitals();
//registerServiceWorker();
serviceWorker.unregister();