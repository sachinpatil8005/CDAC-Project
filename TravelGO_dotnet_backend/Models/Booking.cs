using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Booking
{
    public int IdBooking { get; set; }

    public int PropId { get; set; }

    public int? TravelId { get; set; }

    public DateTime Checkin { get; set; }

    public DateTime Checkout { get; set; }

    public int Totalfare { get; set; }

    public virtual ICollection<BookingPayment> BookingPayments { get; set; } = new List<BookingPayment>();

    public virtual Property Prop { get; set; } = null!;

    public virtual Traveller? Travel { get; set; }
}
