import emailjs from "emailjs-com"; 
const Mailer=()=>{

  function sendEmail(e){
    e.preventDefault();

    emailjs.sendForm(
        "service_5pyjoic",
        "template_fp9uo4r",
        e.target,
        "ZZEkcNih65jFTTx94"
    ).then(res=>{
        console.log(res);
    }).catch(err=>console.log(err));
  }
     
    return(
        <div>

            <h2>Mail</h2>
            <form className="row" onSubmit={sendEmail}>
                <label>name</label>
                <input type="text" name="name" className="form-control"/>

                <label>email</label>
                <input type="email" name="user_email" className="form-control"/>
                
                <label>message</label>
                <textarea name="message" rows="4" className="form-control"/>
                <input type="submit" name="send"/>
            </form>
        </div>
    );
};

export default Mailer;