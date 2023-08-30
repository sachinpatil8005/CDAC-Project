import React, { useState, useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';





function HostPage() {

  const navigate = useNavigate();

  const location = useLocation();
  const { logid, password } = location.state;

  // console.log(logid);
  const [showProfile, setShowProfile] = useState(false);
  const [profileData, setProfileData] = useState(null);
  const [propertyData, setPropertyData] = useState([]);

  const fetchProfileData = async () => {
    try {
      const response = await fetch("http://localhost:8080/getloggedHost?id="+logid);
      if (response.ok) {
        const data = await response.json();
        console.log(data.id_host);
        setProfileData(data);
      } else {
        console.log('Failed to fetch profile data');
      }
    } catch (error) {
      console.error('Error fetching profile data:', error);
    }
  };

  const handleProfileButtonClick = () => {
    fetchProfileData();
    setShowProfile(!showProfile);
  };

  const handleUploadPropertyButtonClick = () => {
    // Make API call for uploading property
    // console.log(profileData.id_host);
    const id_host = profileData.id_host;
    navigate("/addProperty",  { state: { profileData, logid } })
    console.log('Upload Property button clicked');
    
  };

 

  const handleLogoutButtonClick = () => {
    // return to home page
    navigate("/")
    console.log('Logout button clicked');
  };


  const handlePropertyButtonClick = async () => {
    try {
      const response = await fetch("http://localhost:8080/gethostproperty?host="+profileData.id_host);
      if (response.ok) {
        const data = await response.json();
        setPropertyData(data);
      } else {
        console.log('Failed to fetch property data');
      }
    } catch (error) {
      console.error('Error fetching property data:', error);
    }
  };

  useEffect(() => {
    fetchProfileData();
  }, []);

  return (
    <div>
      <nav className="navbar bg-dark navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ms-auto mb-2 mb-lg-0">
            <li className="nav-item mx-2">
              <button className="btn btn-link nav-link white" onClick={handleProfileButtonClick}>
                Profile
              </button>
            </li>
            <li className="nav-item mx-2">
              <button className="btn btn-link nav-link white" onClick={handleUploadPropertyButtonClick}>
                Upload Property
              </button>
            </li>
             
          </ul>
        </div>
        <button className="btn btn-warning white px-3" onClick={handleLogoutButtonClick}>
          <b>Logout</b>
        </button>
      </nav>

      {showProfile && profileData && (
        <div className="card mt-4">
          <div className="card-body">
            <h5 className="card-title">Profile</h5>
            <p className="card-text">Name: {profileData.name}</p>
            <p className="card-text">Email: {profileData.email}</p>
            <p className="card-text">Subscription ID: {profileData.sub_id}</p>
            <p className="card-text">Count: {profileData.count}</p>
          </div>
        </div>
      )}

<button className="btn btn-primary mt-4" onClick={handlePropertyButtonClick}>
        Property Listed
      </button>

      {propertyData.length > 0 && (
        <div className="mt-4">
          <h5>Property Data</h5>
          <table className="table">
            <thead>
              <tr>
                <th>ID</th>
                <th>Address</th>
                <th>State</th>
                <th>City</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody>
              {propertyData.map((property) => (
                <tr key={property.id_property}>
                  <td>{property.id_property}</td>
                  <td>{property.address}</td>
                  <td>{property.state}</td>
                  <td>{property.city}</td>
                  <td>{property.price}</td>
                  <td></td>
                  {/* <td>
                    Parking: {property.id_host},
                    Kitchen: {property.id_ammenity.bedrooms}
                  </td> */}
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}

                  

    </div>
  );
}

export default HostPage;
