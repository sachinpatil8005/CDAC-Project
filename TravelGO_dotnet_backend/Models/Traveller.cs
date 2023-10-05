using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Traveller
{
    public int IdTraveller { get; set; }

    public string Name { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string Gender { get; set; } = null!;

    public string Email { get; set; } = null!;

    public int? IdLogin { get; set; }

    public virtual ICollection<Booking> Bookings { get; set; } = new List<Booking>();

    public virtual Login? IdLoginNavigation { get; set; }
}
