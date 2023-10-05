import './App.css';
import { Route, Routes } from 'react-router-dom';

import FormChoice from './components/FormChoice';
import Register from './components/Register';
import HostRegister from './components/HostRegister';
import Log from './components/Log';
import Home from './components/Home';
import AdminPage from './components/AdminPage';
import HostPage from './components/HostPage';
import TravellerPage from './components/TravellerPage';
import AddProperty from './components/AddProperty';
import SubscriptionComponent from './components/SubscriptionComponent';
import PropertyDetailsPage from './components/PropertyDetailsPage';
import PaymentDetails from './components/PaymentDetails';
 
  

function App() {
  return (
    <div className="App">

    <header>
      <Routes>
          <Route path='' element={<Home/>}></Route>
          <Route path='/login' element={<Log/>}></Route> 
          <Route path='/choice' element={<FormChoice/>}></Route>
          <Route path='/sub' element={<SubscriptionComponent/>}></Route>
          <Route path='/reg' element={<Register/>}></Route>
          <Route path='/host' element={<HostRegister/>}></Route>
          <Route path='/home' element={<Home/>}></Route>
          <Route path='/adminPage' element={<AdminPage/>}></Route>
          <Route path='/hostPage' element={<HostPage/>}></Route>
          <Route path='/travellerPage' element={<TravellerPage/>}></Route>
          <Route path='/addProperty' element={<AddProperty></AddProperty>}></Route>
          <Route path='/propDetails' element={<PropertyDetailsPage/>}></Route>
          <Route path='/payment' element={<PaymentDetails/>}></Route>
      </Routes>
      </header>
       

      {/* <SubscriptionComponent></SubscriptionComponent> */}
      
      {/* <div>
      <Slide></Slide>
      </div> */}
      {/* <Footer></Footer> */}
      
    </div>
  );
}

export default App;
