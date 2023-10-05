using System;
using System.Collections.Generic;

namespace TravelGO_dotnet_backend.Models;

public partial class SubPayment
{
    public int IdSubPayment { get; set; }

    public int IdHost { get; set; }

    public int? Amount { get; set; }

    public string PayMode { get; set; } = null!;

    public virtual Host IdHostNavigation { get; set; } = null!;
}
