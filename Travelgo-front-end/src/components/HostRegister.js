import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';

const HostRegister = () => {
  const location = useLocation();
  const queryParams = new URLSearchParams(location.search); // to get sub option selected
  const id = queryParams.get('sub_id');
  // console.log(id);

  const [formData, setFormData] = useState({
    name: '',
    password: '',
    gender: '',
    email: '',
    sub_id: id,
    payment_mode: ''
  });

  const [emailError, setEmailError] = useState('');

  const navigate = useNavigate();

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (!formData.email.endsWith('.com') ||  formData.password.length < 8) {
      // Show an error message  
      setEmailError('Invalid Password must be 8 character or Check Email');
      console.error('Invalid email format');
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/reghost', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData),
      });

      if (response.ok) {
        navigate('/');
        console.log('Registration successful');
      } else {
        console.log('Registration failed');
      }
    } catch (error) {
      console.error('Error during registration:', error);
    }
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-lg-6">
          <div className="card shadow">
            <div className="card-body">
              <h2 className="card-title text-center mb-4">Host Register</h2>
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="name" className="form-label">
                    Name:
                  </label>
                  <input
                    type="text"
                    id="name"
                    name="name"
                    value={formData.name}
                    onChange={handleInputChange}
                    className="form-control"
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">
                    Password:
                  </label>
                  <input
                    type="password"
                    id="password"
                    name="password"
                    value={formData.password}
                    onChange={handleInputChange}
                    className="form-control"
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="gender" className="form-label">
                    Gender:
                  </label>
                  <select
                    id="gender"
                    name="gender"
                    value={formData.gender}
                    onChange={handleInputChange}
                    className="form-select"
                    required
                  >
                    <option value="">Select Gender</option>
                    <option value="male">Male</option>
                    <option value="female">Female</option>
                    <option value="other">Other</option>
                  </select>
                </div>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    Email:
                  </label>
                  <input
                    type="email"
                    id="email"
                    name="email"
                    value={formData.email}
                    onChange={handleInputChange}
                    className="form-control"
                    required
                  />
                </div>
                 
                <div className="mb-3">
                  <label htmlFor="payment_mode" className="form-label">
                    Payment Mode:
                  </label>
                  <input
                    type="text"
                    id="payment_mode"
                    name="payment_mode"
                    value={formData.payment_mode}
                    onChange={handleInputChange}
                    className="form-control"
                    required
                  />
                </div>
                {emailError && <div className="text-danger">{emailError}</div>}
                <button type="submit" className="btn btn-primary w-100">
                  Register
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default HostRegister;
