import { Link} from 'react-router-dom';
import { NavLink } from 'react-router-dom';
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css'; // Import Bootstrap CSS
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
import Slide from './SlideShow';
import logo from '../Travel.svg'
import Footer from './Footer';



function Home() {

     
  
  return (

  <div>
    <div>
        <nav className="navbar bg-dark navbar-expand-lg bg-body-tertiary fixed-top" data-bs-theme="dark">
          <div class="container">
           <Link className="navbar-brand" to="#">
              <img class="circle" src={logo} alt="Logo" height="70" style={{ marginTop: '-1px' }} />
               
            </Link>
            <button
              class="navbar-toggler"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent"
              aria-controls="navbarSupportedContent"
              aria-expanded="false"
              aria-label="Toggle navigation"
            >
              <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

              <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li className="nav-item mx-2">
                  <NavLink className="nav-link white" to="/" class="nav-link">Home</NavLink>
                    
                </li>



                {/* <li className="nav-item mx-2">
                <NavLink className="nav-link white" to="/about" class="nav-link">About Us</NavLink>

                </li> */}
     
                  <li className="nav-item dropdown pe-4">
                    <li className="nav-link" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Registration
                    </li>
                    <ul className="dropdown-menu">
                      <li>
                        <Link to="/reg" className="dropdown-item ">
                          Traveller
                        </Link>
                      </li>
                      <li>
                        <Link to="/sub" className="dropdown-item nav-link px-3" >
                          Property Owner
                        </Link>
                      </li>
                    </ul>
                  </li>

              </ul>
            </div>
            <Link className="btn btn-warning white px-3" to="/login">
              <b>Login</b>
            </Link>
          </div>
        </nav>
       
      </div>
      
  <div >
  <Slide></Slide>
  <Footer></Footer>
</div>
</div>
  );
}
export default Home;