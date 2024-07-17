import { Routes, BrowserRouter, Route } from 'react-router-dom'
import Toolbar from '../toolbar/toolbar.js'
import Home from '../pages/home';
import Login from '../pages/user/login.js';

function App() {
  return (
    <>
      <BrowserRouter>
        <Toolbar/>
        <Routes>
          <Route path="/" element={<Home/>}/>
          <Route path="/login" element={<Login/>}/>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
