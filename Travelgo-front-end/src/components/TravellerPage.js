import React, { useState, useEffect } from 'react';
import { IconButton, Menu, MenuItem } from '@mui/material';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import logo from '../Travel.svg'

function TravellerPage() {
  const navigate = useNavigate();

  const location = useLocation();
  const { logid, name} = location.state;
  // console.log(logid);

  const [propertyList, setPropertyList] = useState([]);
  const [searchCity, setSearchCity] = useState('');
  const [filteredPropertyList, setFilteredPropertyList] = useState([]);
  const [anchorEl, setAnchorEl] = useState(null);
  const [selectedDates, setSelectedDates] = useState({});
  const [bookingProperty, setBookingProperty] = useState(null);
  const [bookingData, setBookingData] = useState([]);
  const [profileData, setProfileData] = useState(null);

  


  const fetchProfileData = async () => {
    try {
      const response = await fetch("http://localhost:8080/getloggedTraveller?id="+logid);
      if (response.ok) {
        const data = await response.json();
        console.log(data.name);
        setProfileData(data);
      } else {
        console.log('Failed to fetch profile data');
      }
    } catch (error) {
      console.error('Error fetching profile data:', error);
    }
  };


  const fetchPropertyListing = async () => {
    try {
      const response = await fetch('http://localhost:8080/getallprops');
      if (response.ok) {
        const data = await response.json();
        setPropertyList(data);
        setFilteredPropertyList(data);
      } else {
        console.log('Failed to fetch property listing');
      }
    } catch (error) {
      console.error('Error fetching property listing:', error);
    }
  };

  useEffect(() => {
    fetchPropertyListing();
    fetchProfileData();
  }, []);

  const handleSearch = () => {
    if (searchCity.trim() === '') {
      setFilteredPropertyList(propertyList);
    } else {
      const filteredList = propertyList.filter(property => property.city.toLowerCase() === searchCity.toLowerCase());
      setFilteredPropertyList(filteredList);
    }
  };

  const handleProfileIconClick = event => {
    setAnchorEl(event.currentTarget);
  };

  const handleProfileMenuClose = (menuItem) => {
    setAnchorEl(null);
    if (menuItem === 'My Booking') {
      fetchBookingData();
    }
  };

  const handleLogout = () => {
    navigate('/');
  };

  const handleBookProperty = property => {
    setBookingProperty(property);
  };

  const handleDateChange = (date, propertyId) => {
    setSelectedDates(prevDates => ({
      ...prevDates,
      [propertyId]: date,
    }));
  };

  const handleConfirmBooking = async () => {
    if (!bookingProperty || !selectedDates[bookingProperty.id_property]) {
      console.log('Select a property and date before confirming booking.');
      return;
    }

  
    const checkinDate = selectedDates[bookingProperty.id_property];
    const checkoutDate = calculateCheckoutDate(checkinDate);  
    const traveller_id = profileData.id_traveller;
    const property_id = bookingProperty.id_property;
  
    navigate('/propDetails', { state: { property_id, traveller_id, checkinDate, checkoutDate, logid, name} });
    // try {
    //   const response = await fetch('http://localhost:8080/savebooking', {
    //     method: 'POST',
    //     headers: {
    //       'Content-Type': 'application/json',
    //     },
    //     body: JSON.stringify({
    //       prop_id: bookingProperty.id_property,
    //       travel_id: profileData.id_traveller, // Assuming logid is the travel_id of the user
    //       checkin: checkinDate,
    //       checkout: checkoutDate,
    //       totalfare: 100000,
    //       pay_mode:"online",
    //       amount:1000
    //     }),
    //   });
  
    //   if (response.ok) {
    //     console.log('Booking request sent successfully.');
    //     // Reset selected dates and booking property
    //     setSelectedDates({});
    //     setBookingProperty(null);
    //     window.location.reload();
    //   } else {
    //     console.log('Failed to send booking request.');
    //   }
    // } catch (error) {
    //   console.error('Error sending booking request:', error);
    // }
  };

  // Function to calculate the check-out date (you can adjust the logic as needed)
  const calculateCheckoutDate = (checkinDate) => {
  const checkin = new Date(checkinDate);
  const checkout = new Date(checkin);
  checkout.setDate(checkout.getDate() + 1); // Assuming one-day stay
  return checkout.toISOString().split('T')[0]; // Format as "YYYY-MM-DD"
  };

  const fetchBookingData = async () => {
    try {
      const response = await fetch("http://localhost:8080/getbookingbytrveller?t="+profileData.id_traveller);
      if (response.ok) {
        const data = await response.json();
        setBookingData(data);
      } else {
        console.log('Failed to fetch booking data');
      }
    } catch (error) {
      console.error('Error fetching booking data:', error);
    }
  };

  return (
  <div>
    <nav className="navbar navbar-expand-lg navbar-light bg-info">
	  <div className="container">
          <a className="navbar-brand" href="#">
          <img class="rounded" src={logo} alt="Logo" height="70" style={{ marginTop: '-1px' }} />
          </a>
          <div className="input-group">
            <input
              type="text"
              className="form-control rounded-pill"
              placeholder="Where are you going?"
              value={searchCity}
              onChange={(e) => setSearchCity(e.target.value)}
              style={{ width: '200px' }}
            />
            <div className="input-group-append">
              <button className="btn btn-primary rounded-pill" type="button" onClick={handleSearch}>
                Search
              </button>
            </div>
          </div>
          <IconButton
            aria-controls="profile-menu"
            aria-haspopup="true"
            style={{ color: 'black' }}
            onClick={handleProfileIconClick}
          >
            <AccountCircleIcon />

          </IconButton>
          <Menu
            id="profile-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleProfileMenuClose}
          >
            <MenuItem onClick={handleProfileMenuClose}>{name}</MenuItem>
            <MenuItem onClick={() => handleProfileMenuClose('My Booking')}>My Booking</MenuItem>
            <MenuItem onClick={handleLogout}>Logout</MenuItem>
          </Menu>

        </div>

        {/* ... (the navigation bar code) */}
      </nav>

      <div className="container mt-4">
        <div className="row">
          {filteredPropertyList.map(property => (
            <div className="col-md-4 mb-4" key={property.id_property}>
              <div className="card">
                <img src={`data:image/jpeg;base64,${ property.pictures}`}  className="card-img-top" alt={property.address} />
                <div className="card-body">
                  <h5 className="card-title">{property.address}</h5>
                  <p className="card-text">State: {property.state}</p>
                  <p className="card-text">City: {property.city}</p>
                  <p className="card-text">Price: {property.price}</p>
                  {property === bookingProperty ? (
                    <div>
                      <input type="date" onChange={e => handleDateChange(e.target.value, property.id_property)} />
                      <button className="btn btn-primary mt-2" onClick={handleConfirmBooking}>
                        Confirm Booking
                      </button>
                    </div>
                  ) : (
                    <button className="btn btn-primary rounded-circle" onClick={() => handleBookProperty(property)}>
                      Book
                    </button>
                  )}
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
      
      <div className="container mt-4">
      <h2>My Booking</h2>
      <table className="table">
        <thead>
          <tr>
            <th>Property ID</th>
            <th>Check-in</th>
            <th>Check-out</th>
            <th>Total Fare</th>
          </tr>
        </thead>
        <tbody>
          {bookingData.map(booking => (
            <tr key={booking.id_booking}>
              <td>{booking.prop_id.id_property}</td>
              <td>{booking.checkin}</td>
              <td>{booking.checkout}</td>
              <td>{booking.totalfare}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>


    </div>
  );
}

export default TravellerPage;
