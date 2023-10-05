using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Property
{
    public int IdProperty { get; set; }

    public string Address { get; set; } = null!;

    public string State { get; set; } = null!;

    public string City { get; set; } = null!;

    public int Price { get; set; }

    public int? IdHost { get; set; }

    public int? IdAmmenity { get; set; }

    public byte[]? Pictures { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual Ammenity? IdAmmenityNavigation { get; set; }

    public virtual Host? IdHostNavigation { get; set; }
}
