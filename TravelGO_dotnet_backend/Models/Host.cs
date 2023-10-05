using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Host
{
    public int IdHost { get; set; }

    public string Name { get; set; } = null!;

    public string Password { get; set; } = null!;

    public string Gender { get; set; } = null!;

    public string Email { get; set; } = null!;

    public int SubId { get; set; }

    public int Count { get; set; }

    public int? IdLogin { get; set; }

    public virtual Login? IdLoginNavigation { get; set; }

    public virtual ICollection<Property> Properties { get; set; } = new List<Property>();

    public virtual ICollection<SubPayment> SubPayments { get; set; } = new List<SubPayment>();
}
