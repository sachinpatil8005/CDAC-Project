import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import {
  MDBContainer,
  MDBRow,
  MDBCol,
  MDBCard,
  MDBCardBody,
  MDBInput,
  MDBCheckbox,
  MDBBtn
} from 'mdb-react-ui-kit';

export default function AddProperty() {
  const location = useLocation();
  const { profileData, logid } = location.state;

  const [propertyData, setPropertyData] = useState({
    id_host: profileData.id_host,
    address: '',
    state: '',
    city: '',
    price: 0,
    home_type: '',
    summary: '',
    num_rooms: 0,
    num_bedrooms: 0,
    has_kitchen: false,
    has_ac: false,
    has_parking: false,
    has_tv: false,
    has_caretaker: false,
  });

  const navigate = useNavigate();
  const [file, setFile] = useState();

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    const newValue = type === 'checkbox' ? checked : value;
    setPropertyData((prevData) => ({
      ...prevData,
      [name]: newValue,
    }));
  };

  const sendData = (e) => {
    e.preventDefault();
    const reqOptions = {
      method: 'POST',
      headers: { 'content-type': 'application/json' },
      body: JSON.stringify(propertyData),
    };

    // Rest of fetch logic
    fetch("http://localhost:8080/saveprop", reqOptions)
    .then((resp) => {
     // resp.json();
      console.log(resp.status);
      if (resp.ok) {
        return resp.json();
      } else {
        throw new Error("server error")    
      }
    })
    .then(obj => {
      console.log(obj)
      const fd = new FormData();
      fd.append("file", file);
      const reqOptions1 = {
        method: "POST",
      //  headers: {'content-type': 'multipart/form-data'},
        body: fd
      }
      console.log(obj.id_property)
      fetch("http://localhost:8080/uploadimage/"+obj.id_property,reqOptions1)
        .then(resp=>{
          console.log(resp);
          if(resp.status === 200)
          {
            console.log("Prop added successful")
            //const logid = id_host;
            navigate('/hostPage',  { state: { profileData, logid } });
          }
          else {
            alert("Image unable to update.Try again!!");
             
          }
        })
        .then(data => console.log(JSON.stringify(data)))
        })
        .catch((error) => {
        console.log(error);
        alert("Server Error");
        window.location.reload();
      })
      .catch((error)=>{
        console.log(error)
        alert("Server error. Try later")
        console.log(error);
      });

  };

  return (
    <MDBContainer fluid>
      <MDBRow className='d-flex justify-content-center align-items-center'>
        <MDBCol lg='8'>
          <MDBCard className='my-5 rounded-3' style={{ maxWidth: '600px' }}>
            <MDBCardBody className='px-5'>
              <h3 className='mb-4 pb-2 pb-md-0 mb-md-5 px-md-2'>Add Property</h3>
              <form onSubmit={sendData}>
                {/* Address */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Address'
                  name='address'
                  value={propertyData.address}
                  onChange={handleChange}
                />

                {/* State */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='State'
                  name='state'
                  value={propertyData.state}
                  onChange={handleChange}
                />

                {/* City */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='City'
                  name='city'
                  value={propertyData.city}
                  onChange={handleChange}
                />

                {/* Price */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Price'
                  name='price'
                  type='number'
                  value={propertyData.price}
                  onChange={handleChange}
                />

                {/* Home Type */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Home Type'
                  name='home_type'
                  value={propertyData.home_type}
                  onChange={handleChange}
                />

                {/* Summary */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Summary'
                  name='summary'
                  value={propertyData.summary}
                  onChange={handleChange}
                />

                {/* Number of Rooms */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Number of Rooms'
                  name='num_rooms'
                  type='number'
                  value={propertyData.num_rooms}
                  onChange={handleChange}
                />

                {/* Number of Bedrooms */}
                <MDBInput
                  wrapperClass='mb-4'
                  label='Number of Bedrooms'
                  name='num_bedrooms'
                  type='number'
                  value={propertyData.num_bedrooms}
                  onChange={handleChange}
                />

                {/* Features */}
                <MDBCheckbox
                  className='mb-4'
                  label='Has Kitchen'
                  name='has_kitchen'
                  checked={propertyData.has_kitchen}
                  onChange={handleChange}
                />

                <MDBCheckbox
                  className='mb-4'
                  label='Has AC'
                  name='has_ac'
                  checked={propertyData.has_ac}
                  onChange={handleChange}
                />

                <MDBCheckbox
                  className='mb-4'
                  label='Has Parking'
                  name='has_parking'
                  checked={propertyData.has_parking}
                  onChange={handleChange}
                />

                <MDBCheckbox
                  className='mb-4'
                  label='Has TV'
                  name='has_tv'
                  checked={propertyData.has_tv}
                  onChange={handleChange}
                />

                <MDBCheckbox
                  className='mb-4'
                  label='Has Caretaker'
                  name='has_caretaker'
                  checked={propertyData.has_caretaker}
                  onChange={handleChange}
                />

                {/* Image */}
                <MDBInput
                  className='mb-4'
                  label='Add Image'
                  type='file'
                  id='image'
                  name='image'
                  onChange={(e) => setFile(e.target.files[0])}
                />

                <MDBBtn color='success' size='lg' type='submit'>
                  Add Property
                </MDBBtn>
              </form>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
}
