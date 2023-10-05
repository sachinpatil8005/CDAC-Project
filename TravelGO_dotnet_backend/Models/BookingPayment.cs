using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class BookingPayment
{
    public int IdBookPay { get; set; }

    public int BookingId { get; set; }

    public string PayMode { get; set; } = null!;

    public int? Amount { get; set; }

    public virtual Booking Booking { get; set; } = null!;
}
