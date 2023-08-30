import React, { useReducer, useEffect, useState } from 'react';
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBTable,
  MDBTableBody,
  MDBTableHead,
  MDBBtn,
} from 'mdb-react-ui-kit';
import { useNavigate } from 'react-router-dom';

const initialState = {
  loading: true,
  profileList: [],
  hostList: [],
  error: null,
};

const reducer = (state, action) => {
  switch (action.type) {
    case 'FETCH_SUCCESS':
      return {
        loading: false,
        profileList: action.payload.profileList,
        hostList: action.payload.hostList,
        error: null,
      };
    case 'FETCH_ERROR':
      return {
        loading: false,
        profileList: [],
        hostList: [],
        error: action.payload,
      };
    default:
      return state;
  }
};

const AdminPage = () => {
  const navigate = useNavigate();
  const [state, dispatch] = useReducer(reducer, initialState);
  const [showFullList, setShowFullList] = useState(false);
  const [bookingList, setBookingList] = useState([]);
  const [activeTable, setActiveTable] = useState(null); // which table is active


  useEffect(() => {
    // Fetch profile and host data lists from API endpoints
    Promise.all([
      fetch('http://localhost:8080/getalladmin'),
      fetch('http://localhost:8080/getalllogs'),
    ])
      .then((responses) => Promise.all(responses.map((res) => res.json())))
      .then(([profileData, hostData]) => {
        dispatch({
          type: 'FETCH_SUCCESS',
          payload: { profileList: profileData, hostList: hostData },
        });
      })
      .catch((error) => {
        dispatch({ type: 'FETCH_ERROR', payload: error.message });
      });
  }, []);

  const { loading, profileList, hostList, error } = state;

////////////////////////////////////
  const handleBlockButtonClick = async (idLogin) => {
    try {
        const response = await fetch("http://localhost:8080/blocklog?id_login="+idLogin);

      if (response.ok) {
        console.log('Host blocked successfully');
        // Refresh host list after blocking
        // You can update the host list as needed here
        window.location.reload();
      } else {
        console.log('Error blocking host');
      }
    } catch (error) {
      console.error('Error blocking host:', error);
    }
  };
  ////////////////////////////////

  const fetchBookingData = async () => {
    try {
      const response = await fetch('http://localhost:8080/getallbooking');
      if (response.ok) {
        const bookingData = await response.json();
        setBookingList(bookingData);
      } else {
        console.log('Error fetching booking data');
      }
    } catch (error) {
      console.error('Error fetching booking data:', error);
    }
  };

   

  const PaymentData = async () => {
     navigate('/payment');
  };

  const handleLogout = () => {
    // Perform any logout-related actions (e.g., clearing tokens, states, etc.)
    // Then navigate to the home page
    navigate('/');
  };


  return (
    
    

<div
      style={{
        position: 'absolute',
        top: 0,
        left: 0,
        backgroundColor: '#9de2ff',
        width: '100%',
        height: '100vh',
        overflow: 'auto',
      }}
    >
      <button
        onClick={handleLogout}
        className="btn btn-secondary btn-sm"
        style={{
          position: 'absolute',
          top: '20px',
          right: '20px',
        }}
      >
        Logout
      </button>

      <MDBContainer className="py-5">
        
        <MDBRow className="justify-content-center align-items-center h-100">
          
          <MDBCol md="8">
            <div className="card" style={{ borderRadius: '15px' }}>
              <div className="card-body p-4">
                <h2 className="mb-4">Profile Details</h2>
                {loading ? (
                  <p>Loading profile data...</p>
                ) : error ? (
                  <p>Error: {error}</p>
                ) : profileList.length > 0 ? (
                  <div>
                    {showFullList ? (
                      <MDBTable striped bordered>
                        <MDBTableHead>
                          <tr>
                            <th>Name</th>
                            <th>Last-Name</th>
                            <th>Email</th>
                          </tr>
                        </MDBTableHead>
                        <MDBTableBody>
                          {profileList.map((profile, index) => (
                            <tr key={index}>
                              <td>{profile.fname}</td>
                              <td>{profile.lname}</td>
                              <td>{profile.emailid}</td>
                            </tr>
                          ))}
                        </MDBTableBody>
                      </MDBTable>
                    ) : (
                      <p>WELCOME: {profileList[0].fname}</p>
                    )}
                    <MDBBtn
                      color="dark"
                      onClick={() => setShowFullList(!showFullList)}
                      className="mt-3"
                    >
                      {showFullList ? (
                        <i className="fas fa-bars"></i>
                      ) : (
                        <i className="fas fa-list"></i>
                      )}
                    </MDBBtn>
                  </div>
                ) : (
                  <p>No profile data available.</p>
                )}
                <div>
    <button onClick={fetchBookingData} className="btn btn-primary mb-3">
      Fetch Booking Data
    </button>
</div>

                <h2 className="mt-4">Login List</h2>
                <MDBTable striped bordered>
                  <MDBTableHead>
                    <tr>
                      <th>Name</th>
                      <th>Role</th>
                      <th>Status</th>
                      <th>ChangeStatus</th>
                    </tr>
                  </MDBTableHead>
                  <MDBTableBody>
                    {hostList.map((host, index) => (
                      <tr key={index}>
                        <td>{host.name}</td>
                        <td>{host.role_id}</td>
                        <td>{host.status}</td>
                        <td>
                            <button onClick={() => handleBlockButtonClick(host.id_login)}>
                            BLOCK
                            </button>
                        </td>
                      </tr>
                    ))}
                  </MDBTableBody>
                </MDBTable>
              </div>
            </div>
          </MDBCol>
        </MDBRow>
      </MDBContainer>

          {bookingList.length > 0 && (
              <div className="mt-4">
                <h2>Booking Data</h2>
                <MDBTable striped bordered>
                  <MDBTableHead>
                    <tr>
                      <th>Prop ID</th>
                      <th>Travel ID</th>
                      <th>Check-in</th>
                      <th>Check-out</th>
                      <th>Total Fare</th>
                    </tr>
                      </MDBTableHead>
                      <MDBTableBody>
                        {bookingList.map((booking, index) => (
                          <tr key={index}>
                            <td>{booking.prop_id.id_property}</td>
                            <td>{booking.travel_id.id_traveller}</td>
                            <td>{booking.checkin}</td>
                            <td>{booking.checkout}</td>
                            <td>{booking.totalfare}</td>
                          </tr>
                        ))}
                      </MDBTableBody>
                    </MDBTable>
              </div>
                )}

        <button onClick={PaymentData} className="btn btn-primary mb-3">
          Fetch SubPayment Data
        </button>
  </div>
  );
};

export default AdminPage;
