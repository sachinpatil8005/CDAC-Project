using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class Admin
{
    public int Id { get; set; }

    public string Fname { get; set; } = null!;

    public string Lname { get; set; } = null!;

    public string Username { get; set; } = null!;

    public string Password { get; set; } = null!;

    public long? Contact { get; set; }

    public string? Emailid { get; set; }
}
