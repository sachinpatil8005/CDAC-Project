using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Login
{
    public int IdLogin { get; set; }

    public string Name { get; set; } = null!;

    public string Password { get; set; } = null!;

    public int RoleId { get; set; }

    public int? Status { get; set; }

    public virtual ICollection<Host> Hosts { get; set; } = new List<Host>();

    public virtual ICollection<Traveller> Travellers { get; set; } = new List<Traveller>();
}
