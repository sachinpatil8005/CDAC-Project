using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TravelGO_dotnet_backend.Models;

namespace TravelGO_dotnet_backend.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class SubPaymentsController : ControllerBase
    {
        private readonly TravelgoContext _context;

        public SubPaymentsController(TravelgoContext context)
        {
            _context = context;
        }

        // GET: api/SubPayments
        [HttpGet]
        public async Task<ActionResult<IEnumerable<SubPayment>>> GetSubPayments()
        {
          if (_context.SubPayments == null)
          {
              return NotFound();
          }
            return await _context.SubPayments.ToListAsync();
        }

        // GET: api/SubPayments/5
        [HttpGet("{id}")]
        public async Task<ActionResult<SubPayment>> GetSubPayment(int id)
        {
          if (_context.SubPayments == null)
          {
              return NotFound();
          }
            var subPayment = await _context.SubPayments.FindAsync(id);

            if (subPayment == null)
            {
                return NotFound();
            }

            return subPayment;
        }

        // PUT: api/SubPayments/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutSubPayment(int id, SubPayment subPayment)
        {
            if (id != subPayment.IdSubPayment)
            {
                return BadRequest();
            }

            _context.Entry(subPayment).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!SubPaymentExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/SubPayments
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<SubPayment>> PostSubPayment(SubPayment subPayment)
        {
          if (_context.SubPayments == null)
          {
              return Problem("Entity set 'TravelgoContext.SubPayments'  is null.");
          }
            _context.SubPayments.Add(subPayment);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetSubPayment", new { id = subPayment.IdSubPayment }, subPayment);
        }

        // DELETE: api/SubPayments/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteSubPayment(int id)
        {
            if (_context.SubPayments == null)
            {
                return NotFound();
            }
            var subPayment = await _context.SubPayments.FindAsync(id);
            if (subPayment == null)
            {
                return NotFound();
            }

            _context.SubPayments.Remove(subPayment);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool SubPaymentExists(int id)
        {
            return (_context.SubPayments?.Any(e => e.IdSubPayment == id)).GetValueOrDefault();
        }
    }
}
