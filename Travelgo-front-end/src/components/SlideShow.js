import Carousel from 'react-bootstrap/Carousel';

import jaipur from '../Images/jaipur.jpg';
import snow from '../Images/abc.jpg';
import mahal from '../Images/mahal.jpg';



function Slide() {
  return (
   
    <Carousel fade>
      <Carousel.Item>
        <img
          className="d-block w-100 c-Carouselimg"
          src={mahal}
          alt="First slide"
        />
         
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100 c-Carouselimg"
          src={snow}
          alt="Second slide"
        />

         
      </Carousel.Item>
      <Carousel.Item>
        <img
          className="d-block w-100 c-Carouselimg"
          src={jaipur}
          alt="Third slide"
        />
      </Carousel.Item>
    </Carousel>
    
  );
}

export default Slide;