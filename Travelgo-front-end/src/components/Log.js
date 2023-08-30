import React, { useReducer } from 'react';
import { useNavigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

const initialState = {
  uid: '',
  pwd: '',
  loading: false,
  error: '',
};

const reducer = (state, action) => {
  switch (action.type) {
    case 'SET_FIELD':
      return { ...state, [action.field]: action.value };
    case 'START_LOADING':
      return { ...state, loading: true, error: '' };
    case 'STOP_LOADING':
      return { ...state, loading: false };
    case 'SET_ERROR':
      return { ...state, error: action.message, loading: false };
    default:
      return state;
  }
};

function Log() {
  const navigate = useNavigate();
  const [state, dispatch] = useReducer(reducer, initialState);
  const { uid, pwd, loading, error } = state;

  const handleSubmit = async (e) => {
    e.preventDefault();
    dispatch({ type: 'START_LOADING' });

    try {
      const response = await fetch('http://localhost:8080/checklogin', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ uid, pwd }),
      });

      if (response.ok) {
        const data = await response.json();
        const roleId = data.role_id;
        const status = data.status; 



        if (roleId === 0 ) {
          const logid = data.uid;
          const name = data.name;
          navigate('/adminPage', { state: { logid, name } });

        } else if (roleId === 1 && status != 0) {
          const logid = data.id_login;
          const password = pwd;
          navigate('/hostPage', { state: { logid, password } });
          
        } else if (roleId === 2 && status != 0) {
          const logid = data.id_login;
          const name = data.name;
          navigate('/travellerPage', { state: { logid, name } });
          
        }else {
          dispatch({ type: 'SET_ERROR', message: 'Invalid user credentials' });
        }

      } else {
        dispatch({ type: 'SET_ERROR', message: 'Invalid user credentials' });
      }
    } catch (error) {
      console.error('Error fetching data:', error);
      dispatch({ type: 'SET_ERROR', message: 'Invalid user credentials' });
    }
  };

  const handleFieldChange = (field, value) => {
    dispatch({ type: 'SET_FIELD', field, value });
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-4">
          <div className="card p-4">
            <h2 className="text-center mb-4">Log in to TravelGo</h2>
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Name</label>
                <input
                  type="text"
                  className="form-control"
                  value={uid}
                  onChange={(e) => handleFieldChange('uid', e.target.value)}
                  required
                />
              </div>
              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control"
                  value={pwd}
                  onChange={(e) => handleFieldChange('pwd', e.target.value)}
                  required
                />
              </div>
              <button type="submit" className="btn btn-primary btn-block" disabled={loading}>
                {loading ? 'Logging in...' : 'Log in'}
              </button>
            </form>
            {error && <div className="alert alert-danger mt-3">{error}</div>}
            <div className="mt-3">Please enter your credentials.</div>
            <p className="mt-3 text-center">
              Don't have an account? <Link to="/choice" className="nav-lin px3">Sign up</Link>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Log;
