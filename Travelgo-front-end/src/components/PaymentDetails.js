import React, { useState } from 'react';
import {
  MDBTable,
  MDBTableBody,
  MDBTableHead,
} from 'mdb-react-ui-kit';

const PaymentDetails = () => {
  const [subPaymentList, setSubPaymentList] = useState([]);
  const [otherPaymentList, setOtherPaymentList] = useState([]);

  const fetchSubPaymentData = async () => {
    try {
      const response = await fetch('https://localhost:7033/api/SubPayments');
      if (response.ok) {
        const subPaymentData = await response.json();
        setSubPaymentList(subPaymentData);
      } else {
        console.log('Error fetching subpayment data');
      }
    } catch (error) {
      console.error('Error fetching subpayment data:', error);
    }
  };

  const fetchOtherPaymentData = async () => {
    try {
      const response = await fetch('https://localhost:7033/api/BookingPayment');
      if (response.ok) {
        const otherPaymentData = await response.json();
        setOtherPaymentList(otherPaymentData);
      } else {
        console.log('Error fetching other payment data');
      }
    } catch (error) {
      console.error('Error fetching other payment data:', error);
    }
  };

  return (
    <div>
      <div className="mt-4">
        <button onClick={fetchSubPaymentData} className="btn btn-primary mb-3">
          Fetch SubPayment Data
        </button>
        {subPaymentList.length > 0 && (
          <div>
            <h2>SubPayment Data</h2>
            <MDBTable striped bordered>
              <MDBTableHead>
                <tr>
                  <th>idHost</th>
                  <th>Amount</th>
                  <th>PayMode</th>
                </tr>
              </MDBTableHead>
              <MDBTableBody>
                {subPaymentList.map((subPayment, index) => (
                  <tr key={index}>
                    <td>{subPayment.idHost}</td>
                    <td>{subPayment.amount}</td>
                    <td>{subPayment.payMode}</td>
                  </tr>
                ))}
              </MDBTableBody>
            </MDBTable>
          </div>
        )}
      </div>

      <div className="mt-4">
        <button onClick={fetchOtherPaymentData} className="btn btn-primary mb-3">
          Booking Payment Data
        </button>
        {otherPaymentList.length > 0 && (
          <div>
            <h2>Booking Payment Data</h2>
            <MDBTable striped bordered>
              <MDBTableHead>
                <tr>
                  <th>Booking ID</th>
                  <th>Pyament Mode</th>
                  <th>Amount</th>
                </tr>
              </MDBTableHead>
              <MDBTableBody>
                {otherPaymentList.map((otherPayment, index) => (
                  <tr key={index}>
                    <td>{otherPayment.bookingId}</td>
                    <td>{otherPayment.payMode}</td>
                    <td>{otherPayment.amount}</td>
                  </tr>
                ))}
              </MDBTableBody>
            </MDBTable>
          </div>
        )}
      </div>
    </div>
  );
};

export default PaymentDetails;
